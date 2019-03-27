package com.dtb.cadastrocontratos.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CondominioResumidoDto {
	private Long id;
	private String nome;
}
