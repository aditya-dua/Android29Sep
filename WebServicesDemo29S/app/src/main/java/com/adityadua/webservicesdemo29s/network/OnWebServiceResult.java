package com.adityadua.webservicesdemo29s.network;

import com.adityadua.webservicesdemo29s.utils.CommonUtilities;

/**
 * Created by AdityaDua on 22/11/17.
 */

public interface OnWebServiceResult {

    public void getWebResponse(String result, CommonUtilities.SERVICE_TYPE type);
}
