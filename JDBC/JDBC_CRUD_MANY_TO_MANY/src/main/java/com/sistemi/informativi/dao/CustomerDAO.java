package com.sistemi.informativi.dao;

import com.sistemi.informativi.dto.CustomerDTO;
import com.sistemi.informativi.vo.CustomerVO;

import java.sql.SQLException;
import java.util.ArrayList;


/*
Data Transfer Object (DTO):

Scopo: Il DTO viene utilizzato per trasferire dati tra diversi strati di
un'applicazione, spesso tra il livello di presentazione e il livello di servizio
o tra il livello di servizio e il livello di persistenza.
Caratteristiche: Solitamente, un DTO è un oggetto semplice che non contiene logica
di business. È usato per aggregare dati provenienti da diverse fonti o per inviare
dati strutturati in un formato specifico.
Esempio: CustomerDTO potrebbe contenere dati del cliente necessari per creare un
nuovo record del cliente nel sistema, come nome, indirizzo, email, ecc.
Value Object (VO):

Scopo: Il VO rappresenta un oggetto che contiene dati e, a differenza del DTO,
potrebbe contenere una parte di logica legata ai dati stessi. Viene spesso usato
per rappresentare dati immutabili e non cambia durante la sua vita.
Caratteristiche: Un VO è solitamente utilizzato per rappresentare un'entità nel
contesto della business logic dell'applicazione. Può contenere metodi che effettuano
operazioni sui dati che contiene.
Esempio: CustomerVO potrebbe rappresentare un cliente con informazioni
 che devono essere utilizzate nel contesto della logica di business,
 come la visualizzazione dei dati del cliente per un determinato prodotto.
 */
public interface CustomerDAO {
    public int addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerVO> getCustomersNameByProduct(int productId) throws SQLException, ClassNotFoundException;
}
