package com.bilgeadam.constant;

public class RestApiUrls {
    /**
     * Rest Api Servislerimizin versiyonlarını tutmamız için kullanılır.
     */
    public static final String VERSION = "/v1";

    /**
     * CONTROLLER kısımlarındaki map listesini ayrıca burada yazalım.
     */
    public static final String PROFILE = "/profile";
    public static final String USER = "/user";

    /**
     * Genel olarak tanımlanan istekler burada tanımlanır.
     */
    public static final String SAVE= "/save";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";
    public static final String GETALL = "/getall";
    public static final String FINDBYID = "/findbyid";
    public static final String FINDBYNAME = "/findbyname";



    /**
     * Controller için özel olarak tanımladığımız istek urllerini burada tanımlayıp ayrıştırabiliriz.
     */
    public static final String DOLOGIN = "/dologin";
    public static final String REGISTER = "/register";




}
