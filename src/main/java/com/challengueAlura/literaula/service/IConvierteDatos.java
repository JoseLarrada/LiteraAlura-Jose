package com.challengueAlura.literaula.service;

public interface IConvierteDatos {
    <T> T ConvertirDatos(String json,Class<T> clase);
}
