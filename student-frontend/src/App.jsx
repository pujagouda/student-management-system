import { useEffect, useState } from "react";
import "./App.css";


function App(){

  const [students, setStudents] = useState([]);
  const[message, setMessage]=useState("");
  const [editingId, setEditingId] = useState(null);
  const [searchName, setSearchName] = useState("");
  const [page, setPage] = useState(0);
  const [pageSize] = useState(5);
  const [totalPages, setTotalPages] = useState(0);
  const [sortBy, setSortBy] = useState("id");
const [direction, setDirection] = useState("asc");




   const [student, setStudent] = useState({
    id: "",
    name: "",
    age: "",
    course: "",
    marks: ""
  });


 const fetchStudents = async () => {
  try {
    const response = await fetch("http://localhost:8081/students");

    const data = await response.json();

    setStudents(data);
    setPage(0);
    setTotalPages(1);

  } catch (error) {
    console.error("Error fetching students:", error);
  }
};

useEffect(() => {
  fetchStudentsByPage(0);
}, []);



  const handleChange = (event) => {
    const { name, value } = event.target;

    setStudent({
      ...student,
      [name]: value
    });
  };

 const handleSubmit = async (event) => {
  event.preventDefault();

  if (!validateStudent()) {
  return;
}

  try {
    const url = editingId
      ? `http://localhost:8081/students/${editingId}`
      : "http://localhost:8081/students";

    const method = editingId ? "PUT" : "POST";

    const response = await fetch(url, {
      method: method,
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        id: Number(student.id),
        name: student.name,
        age: Number(student.age),
        course: student.course,
        marks: Number(student.marks)
      })
    });

    const data = await response.json();

    if (!response.ok) {
      console.error("Server error:", data);

      if (data.error) {
        setMessage(data.error);
      } else {
        setMessage("Operation failed");
      }

      return;
    }

    if (editingId) {
      // Update student in the table
      setStudents(prevStudents =>
        prevStudents.map(s =>
          s.id === editingId ? data : s
        )
      );

      setMessage("Student updated successfully!");
    } else {
      // Add new student to the table
      setStudents(prevStudents => [...prevStudents, data]);

      setMessage("Student added successfully!");
    }

    // Clear form
    setStudent({
      id: "",
      name: "",
      age: "",
      course: "",
      marks: ""
    });

    setEditingId(null);

  } catch (error) {
    console.error("Error:", error);
    setMessage("Cannot connect to backend");
  }
};


const handleDelete = async (id) => {

  const confirmDelete = window.confirm(
    "Are you sure you want to delete this student?"
  );

  if (!confirmDelete) {
    return;
  }

  try {
    const response = await fetch(
      `http://localhost:8081/students/${id}`,
      {
        method: "DELETE"
      }
    );

    if (!response.ok) {
      setMessage("Failed to delete student");
      return;
    }

    setStudents(prevStudents =>
      prevStudents.filter(student => student.id !== id)
    );

    setMessage("Student deleted successfully!");

  } catch (error) {
    console.error("Error:", error);
    setMessage("Cannot connect to backend");
  }
};


const handleEdit = (student) => {
  setStudent({
    id: student.id,
    name: student.name,
    age: student.age,
    course: student.course,
    marks: student.marks
  });

  setEditingId(student.id);
};


const handleSearch = async () => {
  if (searchName.trim() === "") {
    setMessage("Please enter a name to search");
    return;
  }

  try {
    const response = await fetch(
      `http://localhost:8081/students/search/${searchName}`
    );

    const data = await response.json();

    if (!response.ok) {
      setMessage("Search failed");
      return;
    }

    setStudents(data);
    setMessage(`${data.length} student(s) found`);


  } catch (error) {
    console.error("Error:", error);
    setMessage("Cannot connect to backend");
  }
};

const fetchStudentsByPage = async (pageNumber) => {
  try {
    const response = await fetch(
      `http://localhost:8081/students/page?page=${pageNumber}&size=${pageSize}`
    );

    const data = await response.json();

    setStudents(data.content);
    setTotalPages(data.totalPages);

  } catch (error) {
    console.error("Error fetching students:", error);
  }
};

const fetchStudentsWithSorting = async (
  pageNumber,
  selectedSortBy = sortBy,
  selectedDirection = direction
) => {
  try {
    const response = await fetch(
      `http://localhost:8081/students/page-sort?page=${pageNumber}&size=${pageSize}&sortBy=${selectedSortBy}&direction=${selectedDirection}`
    );

    const data = await response.json();

    setStudents(data.content);
    setTotalPages(data.totalPages);
    setPage(pageNumber);

  } catch (error) {
    console.error("Error fetching students:", error);
  }
};

const validateStudent = () => {
  if (!student.id) {
    setMessage("Student ID is required");
    return false;
  }

  if (!student.name.trim()) {
    setMessage("Name is required");
    return false;
  }

  if (Number(student.age) < 15 || Number(student.age) > 100) {
    setMessage("Age must be between 15 and 100");
    return false;
  }

  if (!student.course.trim()) {
    setMessage("Course is required");
    return false;
  }

  if (Number(student.marks) < 0 || Number(student.marks) > 100) {
    setMessage("Marks must be between 0 and 100");
    return false;
  }

  return true;
};

const handleCancelEdit = () => {
  setEditingId(null);

  setStudent({
    id: "",
    name: "",
    age: "",
    course: "",
    marks: ""
  });

  setMessage("");
};

    return(
<div className="container">
    <h1>Student Management System</h1>
    <p>Welcome to the Student Mangement System</p>


<div className="search-box">

  <input
    type="text"
    placeholder="Search student by name"
    value={searchName}
    onChange={(event) => setSearchName(event.target.value)}
  />

  <button onClick={handleSearch}>Search</button>

  <button onClick={fetchStudents}>Show All</button>

</div>

<div className="sorting-box">

  <label>Sort By:</label>

  <select
    value={sortBy}
    onChange={(event) => setSortBy(event.target.value)}
  >
    <option value="id">ID</option>
    <option value="name">Name</option>
    <option value="age">Age</option>
    <option value="marks">Marks</option>
  </select>

  <label>Direction:</label>

  <select
    value={direction}
    onChange={(event) => setDirection(event.target.value)}
  >
    <option value="asc">Ascending</option>
    <option value="desc">Descending</option>
  </select>

  <button
    onClick={() => fetchStudentsWithSorting(0)}
  >
    Sort
  </button>

</div>

    <h2>Student Form </h2>

<form className="student-form" onSubmit={handleSubmit}>
    <input type="number" name="id" placeholder="Student ID" value={student.id} onChange={handleChange} />
    <input type="text" name="name" placeholder="Name"value={student.name} onChange={handleChange} />
    <input type="number" placeholder="Age" name="age" value={student.age} onChange={handleChange} />
    <input type="text" placeholder="Course"  name="course" value={student.course} onChange={handleChange} />
     <input type="number" placeholder="Marks"   name="marks" value={student.marks} onChange={handleChange}/>

     <button type="submit">{editingId ? "Update Student" :"Add Student"}</button>

     {editingId && (
  <button
    type="button"
    onClick={handleCancelEdit}
  >
    Cancel
  </button>
)}

  </form>
{message && <p className="message">{message}</p>}

{/*"Student Table"*/}

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Course</th>
            <th>Marks</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
           {students.length === 0 ? (
    <tr>
      <td colSpan="6">
        No students found
      </td>
    </tr>
  ) : (
              students.map(student => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.age}</td>
              <td>{student.course}</td>
              <td>{student.marks}</td>
              <td>
                <button className="edit-button" onClick={()=> handleEdit(student)}>Edit</button>
                <button className="delete-button" onClick={() =>handleDelete(student.id)}>Delete</button>
              </td>
            </tr>
          ))
        )}
        </tbody>
      </table>

     <div className="pagination">

  <button
    onClick={() => {
      const previousPage = page - 1;

      setPage(previousPage);

      fetchStudentsWithSorting(
        previousPage,
        sortBy,
        direction
      );
    }}
    disabled={page === 0}
  >
    Previous
  </button>

  <span>
    Page {page + 1} of {totalPages}
  </span>

  <button
    onClick={() => {
      const nextPage = page + 1;

      setPage(nextPage);

      fetchStudentsWithSorting(
        nextPage,
        sortBy,
        direction
      );
    }}
    disabled={page >= totalPages - 1}
  >
    Next
  </button>

</div>
    </div>

  );

  
}


    

    export default App;