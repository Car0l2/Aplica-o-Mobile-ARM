package pt.ismt.arm;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import pt.ismt.arm.ui.listacriancas.ListaCriancasFragment;

public class ApiConnection extends AsyncTask<String, Void, Void> {

    public Fragment _activity;
    private ProgressDialog _pdialog;
    public ArrayList<HashMap<String, String>> _listaCriancas;

    @Override
    protected void onPreExecute(){
        super.onPreExecute();

        //_pdialog = new ProgressDialog(_activity);
        _pdialog.setMessage("Aguardar os dados...");
        _pdialog.setCancelable(false);
        _pdialog.show();
    }

    @Override
    protected Void doInBackground(String... urls){
        HttpURLConnection _conexao;
        InputStream _is;
        String _resJson;

        _pdialog .setMessage("Pedido a ser executado...");

        try{
            //liga o endpoint
            //URL _endpoint = new URL("http://localhost:3001/api/v1/criancas");
            URL _endpoint = new URL(urls[0]);

            //faz a ligação
            _conexao = (HttpURLConnection)_endpoint.openConnection();

            if (urls[1] == "0") { //GET
                _conexao.setRequestMethod("GET");
            } else if (urls[1] == "1") { //POST
                String data = urls[2];
                Log.d("http", "Os dados enviados no body do pedido foram: " + data);

                byte[] dados = data.getBytes(StandardCharsets.UTF_8);

                _conexao.setDoOutput(true);
                _conexao.setRequestMethod("POST");
                _conexao.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                _conexao.setRequestProperty("charset", "utf-8");
                _conexao.setRequestProperty("Content-Length", Integer.toString(dados.length));
                try (DataOutputStream wr = new DataOutputStream(_conexao.getOutputStream())) {
                    wr.write(dados);
                }
            }

            _conexao.setReadTimeout(12000);
            _conexao.setConnectTimeout(12000);
            _conexao.connect();
            Log.d("","O código HTTP do pedido foi:"+_conexao.getResponseCode());

            //analisa a resposta da ligação anterior ao servidor
            int _httpStatus = _conexao.getResponseCode();
            if (_httpStatus != HttpURLConnection.HTTP_BAD_REQUEST || _httpStatus != HttpURLConnection.HTTP_NOT_FOUND) {
                _is = _conexao.getInputStream();
            } else {
                _is = _conexao.getErrorStream();
            }

            _resJson = converteStreamParaString(_is);
            Log.d("http", "A resposta ao pedido HTTP foi: " + _resJson);

            if (_resJson != null) {
                try {
                    JSONObject _listCriancas = new JSONObject(_resJson);

                    //verifica se a API devolveu um array (JSONArray) ou um objeto (JSONObject)
                    if (_listCriancas.get("dados") instanceof JSONArray) {
                        JSONArray _listCriancasJson = _listCriancas.getJSONArray("dados");



                    for (int i = 0; i < _listCriancasJson.length(); i++) {
                        JSONObject _crianca = _listCriancasJson.getJSONObject(i);
                        String id_crianca = _crianca.getString("id_crianca");
                        String nome_crianca = _crianca.getString("nome_crianca");
                        String idade = _crianca.getString("idade");
                        String sala = _crianca.getString("sala");
                        String alergias = _crianca.getString("alergias");
                        String restricao = _crianca.getString("restricao");
                        String doenca = _crianca.getString("doenca_cronica");
                        String contacto = _crianca.getString("contacto");
                        String data = _crianca.getString("data");

                        HashMap<String,String> crianca = new HashMap<>();
                        crianca.put("id_crianca", String.valueOf(id_crianca));
                        crianca.put("nome_crianca", String.valueOf(nome_crianca));
                        crianca.put("idade", String.valueOf(idade));
                        crianca.put("sala", String.valueOf(sala));
                        crianca.put("alergias", String.valueOf(alergias));
                        crianca.put("restricao", String.valueOf(restricao));
                        crianca.put("doenca_cronica", String.valueOf(doenca));
                        crianca.put("contacto", String.valueOf(contacto));
                        crianca.put("data", String.valueOf(data));
                        _listaCriancas.add(crianca);
                    }
                    } else if (_listCriancas.get("dados") instanceof JSONObject) {
                        JSONObject _crianca = _listCriancas.getJSONObject("dados");
                        String id_crianca = _crianca.getString("id_crianca");
                        String nome_crianca = _crianca.getString("nome_crianca");
                        String idade = _crianca.getString("idade");
                        String sala = _crianca.getString("sala");
                        String alergias = _crianca.getString("alergias");
                        String restricao = _crianca.getString("restricao");
                        String doenca = _crianca.getString("doenca_cronica");
                        String contacto = _crianca.getString("contacto");
                        String data = _crianca.getString("data");

                        HashMap<String,String> crianca = new HashMap<>();
                        crianca.put("id_crianca", String.valueOf(id_crianca));
                        crianca.put("nome_crianca", String.valueOf(nome_crianca));
                        crianca.put("idade", String.valueOf(idade));
                        crianca.put("sala", String.valueOf(sala));
                        crianca.put("alergias", String.valueOf(alergias));
                        crianca.put("restricao", String.valueOf(restricao));
                        crianca.put("doenca_cronica", String.valueOf(doenca));
                        crianca.put("contacto", String.valueOf(contacto));
                        crianca.put("data", String.valueOf(data));
                        _listaCriancas.add(crianca);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                }

                _is.close();
            _conexao.disconnect();

        } catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    //esta função converte de stream para string
    private static  String converteStreamParaString(InputStream is) {
        StringBuffer buffer = new StringBuffer();

        try {
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {
                buffer.append(linha);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    @Override
    protected void onPostExecute(Void _resultado){
        super.onPostExecute(_resultado);

        if (_pdialog.isShowing()) {
            _pdialog.dismiss();
        }

    }
}
