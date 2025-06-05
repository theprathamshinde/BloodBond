import React, { useState, useEffect } from "react";
import axios from "axios";
import HeaderStats from "../../sections/header-stats/header_stats";
import DisplayTableComponent from "../../sections/display-table/display-table-component";
import FilterableComponent from "../../sections/filterable/filterable-component";
import InitialDataFetching from "../../utility-functions/initial-data-fetching";

export default function AdminHostBloodDrive() {
	const [data, setData] = useState([]);
	const [filter, setFilter] = useState("");
	const [selectedOpt, setSelectedOpt] = useState("name");
	const [status, setStatus] = useState("normal");
	const [selectedId, setSelectedId] = useState(null);
	const [updatedData, setUpdatedData] = useState({});

	useEffect(() => {
		InitialDataFetching({ source: "host-blood-drive", setData });
	}, []);

	useEffect(() => {
		axios.get("http://localhost:8082/host")
			.then((response) => {
				setData(response.data);
			})
			.catch((error) => {
				console.error(error);
			});
	}, []);

	const filterData = (search) => {
		return data.filter((item) => {
			const propertyValue = item[selectedOpt] ? item[selectedOpt].toString().toLowerCase() : "";
			return selectedOpt === "all" ||
				(selectedOpt === "done" && item.done === (search.toLowerCase() === "yes" ? 1 : 0)) ||
				propertyValue.includes(search.toLowerCase());
		});
	};

	const handleSearchChange = (e) => {
		setFilter(e.target.value);
	};

	const handleInputChange = (e) => {
		setSelectedOpt(e.target.value);
	};

	const handleCheckboxChange = (id) => {
		const updatedItems = data.map(item => {
			if (item.id === id) {
				item.done = !item.done;
				axios.put(`http://localhost:8082/host/${id}`, item)
					.catch(error => console.error(error));
			}
			return item;
		});
		setData(updatedItems);
	};

	const handleUpdateClick = (id) => {
		const item = data.find(item => item.id === id);
		axios.put(`http://localhost:8082/host/${id}`, item)
			.then(response => {
				setData(data.map(item => (item.id === id ? response.data : item)));
				setStatus("normal");
				setSelectedId(null);
			})
			.catch(error => console.error(error));
	};

	const handleDelete = (id) => {
		axios
			.delete(`http://localhost:8082/host/delete/${id}`)
			.then((response) => {
				setData(data.filter((item) => item.id !== id));
			})
			.catch((error) => {
				console.error(error);
			});
	};

	const optionsData = [
		{ id: 1, name: "All", value: "all" },
		{ id: 2, name: "Name", value: "name" },
		{ id: 3, name: "Phone", value: "phone" },
		{ id: 4, name: "Email", value: "email" },
		{ id: 5, name: "Institute", value: "institute" },
		{ id: 6, name: "Designation", value: "designation" },
		{ id: 7, name: "City", value: "city" },
		{ id: 8, name: "Done", value: "done" },
	];

	const tableHeader = [
		"Name",
		"Email",
		"Phone",
		"Institute",
		"Designation",
		"City",
		"Message",
		"Action",
	];

	return (
		<>
			<HeaderStats heading="Blood Drive Hosting Users" />
			<div className="bg-white p-10 m-10 -mt-20 rounded-rsm">
				<FilterableComponent
					filter={filter}
					handleSearchChange={handleSearchChange}
					optionsData={optionsData}
					selectedOpt={selectedOpt}
					handleInputChange={handleInputChange}
				/>

				<div className="overflow-x-scroll">
					<DisplayTableComponent
						tableHeader={tableHeader}
						filterData={filterData}
						filter={filter}
						handleCheckboxChange={handleCheckboxChange}
						type="host-blood-drive"
						handleUpdateClick={handleUpdateClick}
						handleDelete={handleDelete}
						status={status}
						selectedId={selectedId}
						setStatus={setStatus}
						setSelectedId={setSelectedId}
						updatedData={updatedData}
						setUpdatedData={setUpdatedData}
						editing={true}
					/>
				</div>
			</div>
		</>
	);
}
