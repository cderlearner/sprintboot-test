package com.example.sptest.mq;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Base64;

/**
 * Author: linjx
 * Date: 2018/9/28
 */
@RestController
public class TestController {

    @PostMapping("/test")
    public void test(@RequestBody String content) {
        System.err.println(content);
        byte[] asBytes = Base64.getDecoder().decode(content);
        try {
            Thread.sleep(1000l);
            System.out.println("----------------------------------------");
            String res = new String(asBytes, "utf-8");
            System.out.println(res);
            //Map<String, String> map = (Map<String, String>) JSON.parse(res);
            String signature = new String(Base64.getDecoder().decode("A2GdterNjySs9M9tfLwVnwM2nJWJo3F8UIDrtMdQcUPWSPSWwjY6zpcspTbsHckBy9y2nJfLBYdegLhjZq1CFOEFAj5q6oNpiJkA9xeyfod2okyFaxfM2ZZ"), "utf-8");
            Thread.sleep(1000l);
            System.out.println(signature);
            Thread.sleep(1000l);
            String purchaseInfo = new String(Base64.getDecoder().decode("ewoJIm9yaWdpbmFsLXB1cmNoYXNlLWRhdGUtcHN0IiA9ICIyMDE4LTA5LTI5IDAxOjQ3OjI5IEFtZXJpY2EvTG9zX0FuZ2VsZXMiOwoJInF1YW50aXR5IiA9ICIxIjsKCSJ1bmlxdWUtdmVuZG9yLWlkZW50aWZpZXIiID0gIjg4REFBQTk3LTQ0RDEtNDA4Ni05MzBBLUMzMjFDNTgxODhBRCI7Cgkib3JpZ2luYWwtcHVyY2hhc2UtZGF0ZS1tcyIgPSAiMTUzODIxMDg0OTAwMCI7CgkiZXhwaXJlcy1kYXRlLWZvcm1hdHRlZCIgPSAiMjAxOS0wOS0yOSAwODo0NzoyNiBFdGMvR01UIjsKCSJpcy1pbi1pbnRyby1vZmZlci1wZXJpb2QiID0gImZhbHNlIjsKCSJwdXJjaGFzZS1kYXRlLW1zIiA9ICIxNTM4MjEwODQ2MDAwIjsKCSJleHBpcmVzLWRhdGUtZm9ybWF0dGVkLXBzdCIgPSAiMjAxOS0wOS0yOSAwMTo0NzoyNiBBbWVyaWNhL0xvc19BbmdlbGVzIjsKCSJpcy10cmlhbC1wZXJpb2QiID0gImZhbHNlIjsKCSJpdGVtLWlkIiA9ICIxNDE2NDQyMTA1IjsKCSJ1bmlxdWUtaWRlbnRpZmllciIgPSAiYmI1YWRhMTllMGNmMzU0NWFkY2RhN2MxMmQ5ODkzYWNhYTNhNjU5NiI7Cgkib3JpZ2luYWwtdHJhbnNhY3Rpb24taWQiID0gIjQ5MDAwMDM3OTcwNjg4NyI7CgkiZXhwaXJlcy1kYXRlIiA9ICIxNTY5NzQ2ODQ2MDAwIjsKCSJhcHAtaXRlbS1pZCIgPSAiNDMyMjc0MzgwIjsKCSJ0cmFuc2FjdGlvbi1pZCIgPSAiNDkwMDAwMzc5NzA2ODg3IjsKCSJidnJzIiA9ICIxMDk4IjsKCSJ3ZWItb3JkZXItbGluZS1pdGVtLWlkIiA9ICI0OTAwMDAxMDI5NTUwOTIiOwoJInZlcnNpb24tZXh0ZXJuYWwtaWRlbnRpZmllciIgPSAiODI4NjQ5NjM1IjsKCSJiaWQiID0gImNvbS56aGlodS5pb3MiOwoJInByb2R1Y3QtaWQiID0gIjEwMDMzNTE5MTk5MjE4MDMyNjQiOwoJInB1cmNoYXNlLWRhdGUiID0gIjIwMTgtMDktMjkgMDg6NDc6MjYgRXRjL0dNVCI7CgkicHVyY2hhc2UtZGF0ZS1wc3QiID0gIjIwMTgtMDktMjkgMDE6NDc6MjYgQW1lcmljYS9Mb3NfQW5nZWxlcyI7Cgkib3JpZ2luYWwtcHVyY2hhc2UtZGF0ZSIgPSAiMjAxOC0wOS0yOSAwODo0NzoyOSBFdGMvR01UIjsKfQ"), "utf-8");
            System.out.println(purchaseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/csv")
    public void csv(HttpServletResponse response) throws Exception{
        CSVReader reader = new CSVReader(new
                FileReader("/Users/linjiaxing/Downloads/csv_test.csv"));

        OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());

        String[] line;
        while((line=reader.readNext())!=null){
            String _line = line[0];
            writer.write(_line);
        }
        writer.flush();
        writer.close();
    }

    public static void main(String[] argds) throws Exception{
//        String signature = new String(Base64.getDecoder().decode("s9M9tfLwVnwM2nJWJo3F8UIDrtMdQcUPWSPSWwjY6zpcspTbsHckBy9y2nJfLBYdegLhjZq1CFOEFAj5q6oNpiJkA9xeyfod2okyFaxfM2ZZ"), "utf-8");
//        Thread.sleep(1000l);
//        System.out.println(signature);
//        Thread.sleep(1000l);
//        String purchaseInfo = new String(Base64.getDecoder().decode("mFsLXB1cmNoYXNlLWRhdGUtcHN0IiA9ICIyMDE4LTA5LTI5IDAxOjQ3OjI5IEFtZXJpY2EvTG9zX0FuZ2VsZXMiOwoJInF1YW50aXR5IiA9ICIxIjsKCSJ1bmlxdWUtdmVuZG9yLWlkZW50aWZpZXIiID0gIjg4REFBQTk3LTQ0RDEtNDA4Ni05MzBBLUMzMjFDNTgxODhBRCI7Cgkib3JpZ2luYWwtcHVyY2hhc2UtZGF0ZS1tcyIgPSAiMTUzODIxMDg0OTAwMCI7CgkiZXhwaXJlcy1kYXRlLWZvcm1hdHRlZCIgPSAiMjAxOS0wOS0yOSAwODo0NzoyNiBFdGMvR01UIjsKCSJpcy1pbi1pbnRyby1vZmZlci1wZXJpb2QiID0gImZhbHNlIjsKCSJwdXJjaGFzZS1kYXRlLW1zIiA9ICIxNTM4MjEwODQ2MDAwIjsKCSJleHBpcmVzLWRhdGUtZm9ybWF0dGVkLXBzdCIgPSAiMjAxOS0wOS0yOSAwMTo0NzoyNiBBbWVyaWNhL0xvc19BbmdlbGVzIjsKCSJpcy10cmlhbC1wZXJpb2QiID0gImZhbHNlIjsKCSJpdGVtLWlkIiA9ICIxNDE2NDQyMTA1IjsKCSJ1bmlxdWUtaWRlbnRpZmllciIgPSAiYmI1YWRhMTllMGNmMzU0NWFkY2RhN2MxMmQ5ODkzYWNhYTNhNjU5NiI7Cgkib3JpZ2luYWwtdHJhbnNhY3Rpb24taWQiID0gIjQ5MDAwMDM3OTcwNjg4NyI7CgkiZXhwaXJlcy1kYXRlIiA9ICIxNTY5NzQ2ODQ2MDAwIjsKCSJhcHAtaXRlbS1pZCIgPSAiNDMyMjc0MzgwIjsKCSJ0cmFuc2FjdGlvbi1pZCIgPSAiNDkwMDAwMzc5NzA2ODg3IjsKCSJidnJzIiA9ICIxMDk4IjsKCSJ3ZWItb3JkZXItbGluZS1pdGVtLWlkIiA9ICI0OTAwMDAxMDI5NTUwOTIiOwoJInZlcnNpb24tZXh0ZXJuYWwtaWRlbnRpZmllciIgPSAiODI4NjQ5NjM1IjsKCSJiaWQiID0gImNvbS56aGlodS5pb3MiOwoJInByb2R1Y3QtaWQiID0gIjEwMDMzNTE5MTk5MjE4MDMyNjQiOwoJInB1cmNoYXNlLWRhdGUiID0gIjIwMTgtMDktMjkgMDg6NDc6MjYgRXRjL0dNVCI7CgkicHVyY2hhc2UtZGF0ZS1wc3QiID0gIjIwMTgtMDktMjkgMDE6NDc6MjYgQW1lcmljYS9Mb3NfQW5nZWxlcyI7Cgkib3JpZ2luYWwtcHVyY2hhc2UtZGF0ZSIgPSAiMjAxOC0wOS0yOSAwODo0NzoyOSBFdGMvR01UIjsKfQ"), "utf-8");
//        System.out.println(purchaseInfo);

        System.out.println("------------------------------------------------");
        String latest_receipt = "VyZSIgPSAiQTNKRWpIb3RFek9Cc09IQnJjWFVBOHViSkZYd1pZUGZjL0YvbU9uOFJwcWswRzNpN1BkVUl4SXc3TG82UUdWRm1CSTdudkpEL0RBMWlSeHJDbXV5WmhVR2NuT21tb0xvOExNUGhTRTk2YUlhWTRRZVRsNlg3QkF3bzJYYnB3YUdPQ2dkREp2YVJZLzEvQmdva3N0c0xmVDdzcXovM0V5dm5OdlFoOVEzUVF1UXRaeE9sOG5XRW1EUXlSWFRtdHBRb3BpL082MGtJYjFXTEZZNzNIc1lZS1ZmcUVoV3p3Tmp6UnlzZmRsR3RZTHVXbTl2ZGhaaGN5Tk1CNUVoUGlBSlFXT0NSdWc1UVpLdlNQQys4cmJOM2RsdFdXTTJMc1ZySy9GSEQ4MVNqblZycCtpbmw2NGJVaHkvdXFnd2RaWkFuZ1Vza0lDVy9wRmxtTjlvWWc1eFh6RUFBQVdBTUlJRmZEQ0NCR1NnQXdJQkFnSUlEdXRYaCtlZUNZMHdEUVlKS29aSWh2Y05BUUVGQlFBd2daWXhDekFKQmdOVkJBWVRBbFZUTVJNd0VRWURWUVFLREFwQmNIQnNaU0JKYm1NdU1Td3dLZ1lEVlFRTERDTkJjSEJzWlNCWGIzSnNaSGRwWkdVZ1JHVjJaV3h2Y0dWeUlGSmxiR0YwYVc5dWN6RkVNRUlHQTFVRUF3dzdRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTWdRMlZ5ZEdsbWFXTmhkR2x2YmlCQmRYUm9iM0pwZEhrd0hoY05NVFV4TVRFek1ESXhOVEE1V2hjTk1qTXdNakEzTWpFME9EUTNXakNCaVRFM01EVUdBMVVFQXd3dVRXRmpJRUZ3Y0NCVGRHOXlaU0JoYm1RZ2FWUjFibVZ6SUZOMGIzSmxJRkpsWTJWcGNIUWdVMmxuYm1sdVp6RXNNQ29HQTFVRUN3d2pRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTXhFekFSQmdOVkJBb01Da0Z3Y0d4bElFbHVZeTR4Q3pBSkJnTlZCQVlUQWxWVE1JSUJJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBUThBTUlJQkNnS0NBUUVBcGMrQi9TV2lnVnZXaCswajJqTWNqdUlqd0tYRUpzczl4cC9zU2cxVmh2K2tBdGVYeWpsVWJYMS9zbFFZbmNRc1VuR09aSHVDem9tNlNkWUk1YlNJY2M4L1cwWXV4c1FkdUFPcFdLSUVQaUY0MWR1MzBJNFNqWU5NV3lwb041UEM4cjBleE5LaERFcFlVcXNTNCszZEg1Z1ZrRFV0d3N3U3lvMUlnZmRZZUZScjZJd3hOaDlLQmd4SFZQTTNrTGl5a29sOVg2U0ZTdUhBbk9DNnBMdUNsMlAwSzVQQi9UNXZ5c0gxUEttUFVockFKUXAyRHQ3K21mNy93bXYxVzE2c2MxRkpDRmFKekVPUXpJNkJBdENnbDdaY3NhRnBhWWVRRUdnbUpqbTRIUkJ6c0FwZHhYUFEzM1k3MkMzWmlCN2o3QWZQNG83UTAvb21WWUh2NGdOSkl3SURBUUFCbzRJQjF6Q0NBZE13UHdZSUt3WUJCUVVIQVFFRU16QXhNQzhHQ0NzR0FRVUZCekFCaGlOb2RIUndPaTh2YjJOemNDNWhjSEJzWlM1amIyMHZiMk56Y0RBekxYZDNaSEl3TkRBZEJnTlZIUTRFRmdRVWthU2MvTVIydDUrZ2l2Uk45WTgyWGUwckJJVXdEQVlEVlIwVEFRSC9CQUl3QURBZkJnTlZIU01FR0RBV2dCU0lKeGNKcWJZWVlJdnM2N3IyUjFuRlVsU2p0ekNDQVI0R0ExVWRJQVNDQVJVd2dnRVJNSUlCRFFZS0tvWklodmRqWkFVR0FUQ0IvakNCd3dZSUt3WUJCUVVIQWdJd2diWU1nYk5TWld4cFlXNWpaU0J2YmlCMGFHbHpJR05sY25ScFptbGpZWFJsSUdKNUlHRnVlU0J3WVhKMGVTQmhjM04xYldWeklHRmpZMlZ3ZEdGdVkyVWdiMllnZEdobElIUm9aVzRnWVhCd2JHbGpZV0pzWlNCemRHRnVaR0Z5WkNCMFpYSnRjeUJoYm1RZ1kyOXVaR2wwYVc5dWN5QnZaaUIxYzJVc0lHTmxjblJwWm1sallYUmxJSEJ2YkdsamVTQmhibVFnWTJWeWRHbG1hV05oZEdsdmJpQndjbUZqZEdsalpTQnpkR0YwWlcxbGJuUnpMakEyQmdnckJnRUZCUWNDQVJZcWFIUjBjRG92TDNkM2R5NWhjSEJzWlM1amIyMHZZMlZ5ZEdsbWFXTmhkR1ZoZFhSb2IzSnBkSGt2TUE0R0ExVWREd0VCL3dRRUF3SUhnREFRQmdvcWhraUc5Mk5rQmdzQkJBSUZBREFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBRGFZYjB5NDk0MXNyQjI1Q2xtelQ2SXhETUlKZjRGelJqYjY5RDcwYS9DV1MyNHlGdzRCWjMrUGkxeTRGRkt3TjI3YTQvdncxTG56THJSZHJqbjhmNUhlNXNXZVZ0Qk5lcGhtR2R2aGFJSlhuWTR3UGMvem83Y1lmcnBuNFpVaGNvT0FvT3NBUU55MjVvQVE1SDNPNXlBWDk4dDUvR2lvcWJpc0IvS0FnWE5ucmZTZW1NL2oxbU9DK1JOdXhUR2Y4YmdwUHllSUdxTktYODZlT2ExR2lXb1IxWmRFV0JHTGp3Vi8xQ0tuUGFObVNBTW5CakxQNGpRQmt1bGhnd0h5dmozWEthYmxiS3RZZGFHNllRdlZNcHpjWm04dzdISG9aUS9PamJiOUlZQVlNTnBJcjdONFl0UkhhTFNQUWp2eWdhWndYRzU2QWV6bEhSVEJoTDhjVHFBPT0iOwoJInB1cmNoYXNlLWluZm8iID0gImV3b0pJbTl5YVdkcGJtRnNMWEIxY21Ob1lYTmxMV1JoZEdVdGNITjBJaUE5SUNJeU1ERTVMVEF4TFRFMElEQXhPakEzT2pJeklFRnRaWEpwWTJFdlRHOXpYMEZ1WjJWc1pYTWlPd29KSW5GMVlXNTBhWFI1SWlBOUlDSXhJanNLQ1NKMWJtbHhkV1V0ZG1WdVpHOXlMV2xrWlc1MGFXWnBaWElpSUQwZ0lqQXlNa1F6UXpRd0xURkdORVl0TkVReVFpMDVOakJCTFRRME5EVkRNelkxTURjNFFpSTdDZ2tpYjNKcFoybHVZV3d0Y0hWeVkyaGhjMlV0WkdGMFpTMXRjeUlnUFNBaU1UVTBOelExTmpnME16QXdNQ0k3Q2draVpYaHdhWEpsY3kxa1lYUmxMV1p2Y20xaGRIUmxaQ0lnUFNBaU1qQXhPUzB3TkMweE5DQXdPRG93TnpveU1pQkZkR012UjAxVUlqc0tDU0pwY3kxcGJpMXBiblJ5YnkxdlptWmxjaTF3WlhKcGIyUWlJRDBnSW5SeWRXVWlPd29KSW5CMWNtTm9ZWE5sTFdSaGRHVXRiWE1pSUQwZ0lqRTFORGMwTlRZNE5ESXdNREFpT3dvSkltVjRjR2x5WlhNdFpHRjBaUzFtYjNKdFlYUjBaV1F0Y0hOMElpQTlJQ0l5TURFNUxUQTBMVEUwSURBeE9qQTNPakl5SUVGdFpYSnBZMkV2VEc5elgwRnVaMlZzWlhNaU93b0pJbWx6TFhSeWFXRnNMWEJsY21sdlpDSWdQU0FpWm1Gc2MyVWlPd29KSW1sMFpXMHRhV1FpSUQwZ0lqRTBNelk1TlRrek9UVWlPd29KSW5WdWFYRjFaUzFwWkdWdWRHbG1hV1Z5SWlBOUlDSTVaVGczTm1ZMU1tVXdaRFl3WVRjek1tRTBPRFppWVRNMFptWmlNekkyWlRaaFltWTJPR1E0SWpzS0NTSnZjbWxuYVc1aGJDMTBjbUZ1YzJGamRHbHZiaTFwWkNJZ1BTQWlOVFl3TURBd016TTJPVE0wTkRRd0lqc0tDU0psZUhCcGNtVnpMV1JoZEdVaUlEMGdJakUxTlRVeU1qa3lOREl3TURBaU93b0pJbUZ3Y0MxcGRHVnRMV2xrSWlBOUlDSTBNekl5TnpRek9EQWlPd29KSW5SeVlXNXpZV04wYVc5dUxXbGtJaUE5SUNJMU5qQXdNREF6TXpZNU16UTBOREFpT3dvSkltSjJjbk1pSUQwZ0lqRXhPRFFpT3dvSkluZGxZaTF2Y21SbGNpMXNhVzVsTFdsMFpXMHRhV1FpSUQwZ0lqVTJNREF3TURBNU16RTJPVGsxT0NJN0Nna2lkbVZ5YzJsdmJpMWxlSFJsY201aGJDMXBaR1Z1ZEdsbWFXVnlJaUE5SUNJNE1qazNOekV5TXpjaU93b0pJbUpwWkNJZ1BTQWlZMjl0TG5wb2FXaDFMbWx2Y3lJN0Nna2ljSEp2WkhWamRDMXBaQ0lnUFNBaU1UQXdOelkyTWpFMU1UWTROamt3TlRnMU5pSTdDZ2tpY0hWeVkyaGhjMlV0WkdGMFpTSWdQU0FpTWpBeE9TMHdNUzB4TkNBd09Ub3dOem95TWlCRmRHTXZSMDFVSWpzS0NTSndkWEpqYUdGelpTMWtZWFJsTFhCemRDSWdQU0FpTWpBeE9TMHdNUzB4TkNBd01Ub3dOem95TWlCQmJXVnlhV05oTDB4dmMxOUJibWRsYkdWeklqc0tDU0p2Y21sbmFXNWhiQzF3ZFhKamFHRnpaUzFrWVhSbElpQTlJQ0l5TURFNUxUQXhMVEUwSURBNU9qQTNPakl6SUVWMFl5OUhUVlFpT3dwOSI7CgkicG9kIiA9ICI1NiI7Cgkic2lnbmluZy1zdGF0dXMiID0gIjAiOwp9";
        latest_receipt = new String(Base64.getDecoder().decode(latest_receipt));
        System.out.println("latest_receipt:");
        System.out.println(latest_receipt);

        System.out.println("------------------------------------------------");
        System.out.println("signature:");
        String signature = "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";
        signature = new String(Base64.getDecoder().decode(signature), "UTF-8");
        System.out.println(signature);

    }
}
