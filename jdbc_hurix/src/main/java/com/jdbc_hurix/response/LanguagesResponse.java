package com.jdbc_hurix.response;

import java.util.List;

import com.jdbc_hurix.entity.Languages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguagesResponse {

	public List<Languages> languages;
}
