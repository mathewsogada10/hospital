package com.hospital.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historico_entities database table.
 * 
 */
@Entity
@Table(name="historico_entities")
@NamedQuery(name="HistoricoEntity.findAll", query="SELECT h FROM HistoricoEntity h")
public class HistoricoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="int_code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int intCode;

	@Column(name="entity_code")
	private int entityCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private Date lastUpdate;

	private String modification;

	@Column(name="type_of_entity")
	private String typeOfEntity;

	@Column(name="user_id")
	private int userId;

	public HistoricoEntity() {
	}

	public int getIntCode() {
		return this.intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public int getEntityCode() {
		return this.entityCode;
	}

	public void setEntityCode(int entityCode) {
		this.entityCode = entityCode;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getModification() {
		return this.modification;
	}

	public void setModification(String modification) {
		this.modification = modification;
	}

	public String getTypeOfEntity() {
		return this.typeOfEntity;
	}

	public void setTypeOfEntity(String typeOfEntity) {
		this.typeOfEntity = typeOfEntity;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}