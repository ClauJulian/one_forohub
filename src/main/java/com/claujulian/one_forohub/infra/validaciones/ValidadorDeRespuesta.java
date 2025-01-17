package com.claujulian.one_forohub.infra.validaciones;

import com.claujulian.one_forohub.dto.respuesta.DatosRegistraRespuesta;

public interface ValidadorDeRespuesta {
    void validar(DatosRegistraRespuesta datos);
}
