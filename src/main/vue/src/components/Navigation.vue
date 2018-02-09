<template>
    <div>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1"><router-link to="/">Home</router-link></el-menu-item>
            <el-submenu index="2">
                <template slot="title">Apps</template>
                <el-menu-item index="2-1"><router-link to="/todolist">To-do list</router-link></el-menu-item>
                <el-menu-item index="2-2">item two</el-menu-item>
                <el-menu-item index="2-3">item three</el-menu-item>
            </el-submenu>
        <el-menu-item index="3"><a href="#" target="_blank">About</a></el-menu-item>
        </el-menu>
        <div class="line"></div>
    </div>
</template>
<script>
    export default{
        name: 'Navigation',
        data(){
            return {
                activeIndex: '1',
                activeIndex2: '1'
            }
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>