package com.hexaware.cricket.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

	private int playerId;

	@NotBlank(message = "Player name is required")
	private String playerName;

	@NotNull(message = "Jersey number is required")
	@Min(value = 0, message = "Jersey number cannot be negative")
	private Integer jerseyNumber;

	@NotBlank(message = "Role is required")
	@Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder",
			message = "Role must be Batsman, Bowler, Keeper, or All Rounder")
	private String role;

	@Min(value = 0, message = "Total matches cannot be negative")
	private int totalMatches;

	@NotBlank(message = "Team name is required")
	private String teamName;

	@NotBlank(message = "Country name is required")
	private String countryName;

	private String description;
}
