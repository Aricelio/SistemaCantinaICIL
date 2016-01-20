package br.com.sistemaCantinaICIL.model;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rendimento.class)
public abstract class Rendimento_ {

	public static volatile SingularAttribute<Rendimento, Calendar> data;
	public static volatile SingularAttribute<Rendimento, BigDecimal> valor;
	public static volatile SingularAttribute<Rendimento, String> nome;
	public static volatile SingularAttribute<Rendimento, Long> id;
	public static volatile SingularAttribute<Rendimento, String> descricao;

}

