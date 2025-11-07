package utilities;

import io.restassured.response.Response;

public class TestContext {

    private Response getResponse;
    private Response postResponse;
    private Response patchResponse;
    private Response putResponse;
    private Response deleteResponse;

    public TestContext() {
        System.out.println("🧩 TestContext initialized successfully.");
    }


    public Response getGetResponse() { return getResponse; }
    public void setGetResponse(Response getResponse) { this.getResponse = getResponse; }

    public Response getPostResponse() { return postResponse; }
    public void setPostResponse(Response postResponse) { this.postResponse = postResponse; }

    public Response getPatchResponse() { return patchResponse; }
    public void setPatchResponse(Response patchResponse) { this.patchResponse = patchResponse; }

    public Response getPutResponse() { return putResponse; }
    public void setPutResponse(Response putResponse) { this.putResponse = putResponse; }

    public Response getDeleteResponse() { return deleteResponse; }
    public void setDeleteResponse(Response deleteResponse) { this.deleteResponse = deleteResponse; }
}
