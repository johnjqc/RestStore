package com.jsoft.reststore.model.web;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

/**
 * Class to represent a  view
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode
public class BuyRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String user;

    @NotNull
    private String password;

    @NotNull
    private Long shopId;

    @NotNull
    private Map<String, Integer> product;

}
