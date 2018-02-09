package com.maynar.services;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.maynar.dto.Task;

@Path("/tasks")
@Produces("application/json;charset=utf-8")
public class TaskService {
	
	private static final Logger LOGGER = Logger.getLogger(TaskService.class.getName());
	
	private static Task[] tasks = { new Task("1", "Tarea 1"), new Task("2", "Tarea 2"), new Task("3", "Tarea 3") };

	@GET
	public Response list() {
		LOGGER.info("GET - obteniendo listado de tareas");
		System.out.println(tasks.toString());
		return Response.ok(tasks).build();

	}

}
