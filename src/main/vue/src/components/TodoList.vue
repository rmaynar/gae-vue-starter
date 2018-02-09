<template>
    <div id="todo-list">
        <h2>{{titulo}}</h2>
        <ul class="listado">
            <li v-for="tarea in tareas">
                <el-checkbox v-model="tarea.checked">{{tarea.description}}</el-checkbox><a class="el-icon-delete" v-on:click="eliminarTarea(tarea)"></a>
            </li>
        </ul>
        <el-form ref="form" :model="form" label-width="180px">
            <el-form-item label="Insert new task">
                <el-input class="input-class" v-model="form.nuevatarea.description" placeholder="..task description" size="40" ></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="anadir">Insert</el-button>
                <el-button @click="eliminarTodas">Delete</el-button>
            </el-form-item>
        </el-form>
        <el-button @click="listTareas">Rest call!</el-button>
        <pre class="prettyprint" id="quine">{{restresponse}}</pre>
    </div>
</template>
<script>

import axios from 'axios'

 export default{
     name: 'TodoList',
     data(){
         return {
             titulo:"To-do list",
             form:{
                 nuevatarea:{'description':''}
             },
             tareas:""                
             ,
            restresponse:"",
            errors:[]
             
         }
     },
     methods:{
         anadir(){
             var tarea = {'description':this.$data.form.nuevatarea.description};
             if(tarea.description!=""){
                 tarea.checked=false;
                 this.$data.tareas.push(tarea);
                alert("Task successfully saved!");
             }else{
                 alert("Task is blank")
             }
             
         },
         eliminarTodas(){
             for(var i = 0; i<this.$data.tareas.length;i++){
                 if(this.$data.tareas[i].checked){
                     this.$data.tareas.splice(i, 1);
                 }
             }
         },
         eliminarTarea(tarea){
             this.$data.tareas.splice(this.$data.tareas.indexOf(tarea), 1);
         },
         listTareas() {
             console.log("listTareas");
            axios.get("http://localhost:8080/rest/tasks")
                .then(restresponse => {
                // JSON responses are automatically parsed.
                this.restresponse = restresponse.data;
                this.$data.tareas = this.restresponse;
                })
                .catch(e => {
                this.errors.push(e)
                })
            },
        mounted: function () {
            this.$nextTick(function () {
                this.listTareas();
            })
        }
     }
     
     
 }   
 
</script>

<style>
 .nuevatareaLbl{
     margin-right:1em;
 }   
 #todo-list{
     text-align:left;
 }
 .listado{
     list-style: none;
 }
 .input-class{
     width:200px;
 }
 .operative {
    font-weight: bold;
    border: 1px solid yellow;
}
pre.prettyprint {
    color:white;
}
#quine {
    border: 4px solid #88c;
}
</style>