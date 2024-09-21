package com.yanvelasco.secure.api.domain.user.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Abstract base class for items with common properties")
public abstract class BaseItem {

    @Id
    @GeneratedValue(generator = "UUID")
    @Setter(AccessLevel.NONE)
    @Schema(description = "Unique identifier of the item", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Icon representing the item", example = "icon.png")
    private String icon;

    @Schema(description = "Description of the item", example = "This is a sample item description.")
    private String description;
}