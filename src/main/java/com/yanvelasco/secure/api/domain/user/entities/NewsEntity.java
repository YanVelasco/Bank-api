package com.yanvelasco.secure.api.domain.user.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "news")
@Schema(description = "Entity representing a news item")
public class NewsEntity extends BaseItem {
}