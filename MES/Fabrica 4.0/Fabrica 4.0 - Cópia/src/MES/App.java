package MES;

import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;


public class App {
    public static void main(String[] args) throws UaException, InterruptedException, ExecutionException {

        OpcUaClient client = OpcUaClient.create("opc.tcp://Vasco-Laptop:4840");
        client.connect().get();
        
        
        NodeId nodeId = new NodeId(4,"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.E2_RN_S");
        String Variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(29, 31);
        System.out.println(Variable);
        
        
        NodeId writeId = new NodeId(4,"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.E2_RN_S");
        short i=2;
        Variant v = new Variant( i);
        
        DataValue dv = new DataValue(v, null, null);
        Variable = client.writeValue(writeId, dv).get().toString();
        System.out.println(Variable);
        
        Variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(29, 31);
        System.out.println(Variable);
        
//        NodeId nodeId = new NodeId(4,"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C1");
//
//        String Variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString();
//
//        System.out.println(Variable);

    }
    
    
}