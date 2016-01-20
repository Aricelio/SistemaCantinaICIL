
package br.com.sistemaCantinaICIL.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Aricelio - 16/01/2016
 */

@Entity
public class Rendimento implements Serializable{
    
    // Variaveis
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String descricao;
    private BigDecimal valor;
    
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new Exception("Atenção! O campo Nome é obrigatório!");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(String strValor) throws Exception{
      try {
            BigDecimal valor = new BigDecimal(strValor);
            if (valor.compareTo(BigDecimal.ZERO) > 0) {
                this.valor = valor;
            } else {
                throw new Exception("Atenção! O Valor da Despesa deve ser maior que zero!");
            }
        } catch (NumberFormatException ne) {
            throw new Exception("Atenção! O Valor da Despesa deve ser um número!");
        }
    }

    public Calendar getData() {
        return data;
    }

    public void setData(String strDate) throws Exception {
        try {            
            SimpleDateFormat simpleDateFomart = new SimpleDateFormat("dd/MM/yyyy");
            Date data = simpleDateFomart.parse(strDate);
            Calendar auxCalendar = Calendar.getInstance();
            auxCalendar.setTime(data);

            this.data = auxCalendar;
        } 
        catch (ParseException pe) {
            throw new Exception("Atenção! A Data é inválida!");
        }
        catch (Exception pe) {
            throw new Exception("Atenção! A Data é inválida!");
        }
    }
    
}
