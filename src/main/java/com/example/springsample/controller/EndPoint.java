package com.example.springsample.controller;

public class EndPoint {

    public static final String BASE_URL = "/api/v1";

    public static class WorldEndPoint {

        public static final String WORLD_API_BASE_URL = EndPoint.BASE_URL + "/world";

        public static final String GET = "/{code}";
    }
}
