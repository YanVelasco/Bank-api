package com.yanvelasco.secure.api.domain.user.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "features")
@Schema(description = "Entity representing a feature")
public class FeatureEntity extends BaseItem {
}