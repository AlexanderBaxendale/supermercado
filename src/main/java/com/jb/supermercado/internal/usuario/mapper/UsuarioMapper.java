package com.jb.supermercado.internal.usuario.mapper;

import com.jb.supermercado.internal.usuario.dto.UsuarioRequest;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponse;
import com.jb.supermercado.internal.usuario.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static UsuarioEntity requestParaEntidade(UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuarioRequest.getNome());
        usuarioEntity.setEmail(usuarioRequest.getEmail());
        usuarioEntity.setSenha(usuarioRequest.getSenha());
        return usuarioEntity;
    }

    public static UsuarioResponse entidadeParaResponse(UsuarioEntity usuarioEntity) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuarioEntity.getId());
        usuarioResponse.setNome(usuarioEntity.getNome());
        usuarioResponse.setEmail(usuarioEntity.getEmail());
        return usuarioResponse;
    }

    public static List<UsuarioResponse> entidadeParaResponseList(List<UsuarioEntity> usuarioEntityList) {
        List<UsuarioResponse> usuarioResponseList = new ArrayList<>();
        for (UsuarioEntity usuarioEntity : usuarioEntityList) {
            usuarioResponseList.add(entidadeParaResponse(usuarioEntity));
        }
        return usuarioResponseList;
    }


}
