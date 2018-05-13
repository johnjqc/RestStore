package com.jsoft.reststore.model.converter;

import com.jsoft.reststore.model.Buy;
import com.jsoft.reststore.model.web.BuyViewResponse;

/**
 * Utility class to convert {@link Buy} between web and domain.
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
public final class BuyConverter {

    // The private constructor by utility class
    private BuyConverter(){}

    /**
     * Converts a domain layer Buy to a web layer buy
     *
     * @param buy
     *            the domain {@link Buy}
     * @return the web {@link BuyViewResponse}
     */
    public static BuyViewResponse domainToWeb(Buy buy) {
        BuyViewResponse result = new BuyViewResponse();


        return result;
    }

    /**
     * Converts a web layer Buy to a domain layer Buy
     *
     * @param buy
     *            the web {@link BuyViewResponse}
     * @return the domain {@link Buy}
     */
    public static Buy webToDomain(BuyViewResponse buy) {
        Buy result = new Buy();



        return  result;
    }

}
