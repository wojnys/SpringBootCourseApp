import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import './App.css';
import MainPage from "./pages/MainPage/MainPage";
import MainCoursePage from "./pages/Admin/Course/MainCoursePage/MainCoursePage";
import Navbar from "./components/Navbar/Navbar";
import CreateCoursePage from "./pages/Admin/Course/CreateCoursePage/CreateCoursePage";
import AllCoursesPage from "./pages/Admin/Course/AllCoursesPage/AllCoursesPage";
import MainUserPage from "./pages/Admin/User/MainUserPage/MainUserPage";
import AllUsersPage from "./pages/Admin/User/AllUsersPage/AllUsersPage";
import CourseDetail from "./pages/Admin/Course/CourseDetail/CourseDetail";

function App() {
    return (
        <div className="App">
            <Navbar/>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<MainPage/>}/>
                    /* Course routes */
                    <Route path="/admin/course" element={<MainCoursePage/>}/>
                    <Route path="/admin/course/create" element={<CreateCoursePage/>}/>
                    <Route path="/admin/course/all" element={<AllCoursesPage/>}/>
                    <Route path="/admin/course/:courseId" element={<CourseDetail/>}/>

                    /* User routes */
                    <Route path="/admin/user" element={<MainUserPage/>}/>
                    <Route path="/admin/user/all" element={<AllUsersPage/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
