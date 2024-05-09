import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";
import TextField from '@mui/material/TextField';
import {SubmitHandler, useForm} from "react-hook-form";
import {Button, Container, Grid, MenuItem, Select} from "@mui/material";
import {makeStyles} from "@material-ui/core/styles";
import {useNotification} from "../../../../components/Context/NotificationContext";

const useStyles: any = makeStyles((theme: any) => ({
    root: {
        "& .MuiTextField-root": {
            width: "100%",
        },
        "& .MuiOutlinedInput-root": {
            borderRadius: "12px",
        },
    },
}));

type Course = {
    id:number,
    name: string
    description: string
    price: number,
    topicId: number
}

function CourseDetail() {
    const {courseId} = useParams()

    const { showNotification } = useNotification();

    const [courseDetail, setCourseDetail] = useState<Course>()

    const {
        register,
        handleSubmit,
        formState: {errors},
        setValue
    } = useForm<Course>()

    const getCourseDetail = async () => {
        try {
            const response = await axios.get(`${process.env.REACT_APP_SERVER_URL}/api/course/${courseId}`)
            setCourseDetail(response.data)
            console.log(response.data)
            setValue("name", response.data.name)
            setValue("description", response.data.description)
            setValue("price", response.data.price)
        }catch(e){
            showNotification(["Cannot connect to the server"], 'error');
            console.log(e)
        }
    }

    const onSubmit: SubmitHandler<Course> = async (data) => {
        try {
            const response = await axios.put(`${process.env.REACT_APP_SERVER_URL}/api/course/${courseDetail?.id}`, {
                    name: data.name,
                    description: data.description,
                    price: data.price,
            })
            showNotification([ response.data ], 'success');
        } catch (e) {
            showNotification([ 'Cannot connect to server' ], 'error');
        }
    }

    const classes = useStyles();

    useEffect(() => {
        getCourseDetail()
    }, []);
    return (
        <Container>
            <h1 className={"text-left text-xl p-6"}>Course Detail</h1>
            <form className={classes.root} onSubmit={handleSubmit(onSubmit)}>
                <Grid spacing={3} p={4} container>
                    <Grid item xs={12} sm={12} md={6}>
                        <TextField id="outlined-basic" label="Course Name" variant="outlined" defaultValue={"x"}
                                   type={"text"} {...register("name", {
                            required: "Name of Course is required", maxLength: {
                                value: 100,
                                message: "The Course Name cannot be so long"
                            }
                        })}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6}>
                        <TextField id="outlined-basic" label="Course Description" defaultValue={"x"}
                                   variant="outlined" type={"text"} {...register("description", {
                            required: "Description of Course is required",
                            maxLength: 1000
                        })}
                        />
                    </Grid>
                    <Grid item xs={12} sm={12} md={6}>
                        <TextField id="outlined-basic" label="Course Price" defaultValue={1}
                                   variant="outlined"
                                   type={"number"} {...register("price", {required: "Price for Course is required"})}/>

                    </Grid>
                    <Grid item xs={12}>
                        <Button variant="contained" color="success" type={"submit"}>
                            UPDATE Course
                        </Button>
                    </Grid>
                </Grid>
            </form>
        </Container>
    );
}

export default CourseDetail;
