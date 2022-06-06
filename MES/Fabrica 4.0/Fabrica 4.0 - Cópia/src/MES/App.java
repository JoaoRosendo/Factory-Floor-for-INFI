package MES;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
//opc.tcp://Vasco-Laptop:4840

import lombok.ToString;

public class App {
	
	static String[] array_ids=new String[] {
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C1",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C2"};
	
	static String[] maq_ids= {
			"",
			"",
			"",
			"",
			"",
			"",
			};
	
	static String[] maq_tools= {
			"",
			"",
			"",
			"",
			"",
			"",
			};
	
	static String[] dock_ids= {
			"",
			"",
			"",
			};
	
	
	static OpcUaClient client;
	
	static String tools_time_ant=null;
	static String pieces_time_ant=null;
	
    public static int send_pieces(ArrayList<Piece> day_pieces) throws UaException, InterruptedException, ExecutionException { 
    	//returns the nr of pieces not correctly sent
    	//TRY CATCH ROUTINE NEEDED
    	String variable;
    	client = OpcUaClient.create("opc.tcp://Vasco-Laptop:4840");
        client.connect().get();
    	int errors=0;
        int ready=1;
        NodeId nodeId;
        //for (int i=0;i<12;i++) {
	        
        	while(ready!=1) {
        		nodeId = new NodeId(4,"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.W1out0_S");
        		variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(30, 35).replace(", ", "");
        		if(variable=="false") {
        			ready=1;
        		}
        	}

        	nodeId=new NodeId(4,"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C5"); 
        	

        	//Creates a array of shorts and inserts there the values to send adntransforms them to string to be able to compare 
        	short[] machines=day_pieces.get(1).getMachines(); 
        	short[] data= {0,0,0,0,0,0};
        	String machines_s=""; 
        	for(int j=0;j<6;j++){
        		data[j]=machines[j];
        		machines_s.concat(String.valueOf(day_pieces.get(1).machines[j]));
        		System.out.print(""+machines[j]);
        	}
        	
        	System.out.println();
        	//Sending Values Variant 
        	Variant v = new Variant(data); DataValue dv = new DataValue(v, null, null); 
        	variable = client.writeValue(nodeId,dv).get().toString().substring(31, 50).replace(", ", "");
        	System.out.println(variable);

        	//Check if the sent array and the one we have here are equal variable =
        	variable=client.readValue(0, TimestampsToReturn.Both,nodeId).get().toString().substring(31, 44).replace(", ", "");
        	System.out.println(variable);
        	if(variable!=machines_s) { errors++; }
        	

        	System.out.println(variable); System.out.println();
        	
        //}
        System.out.println(errors);

        return errors;
    }
    
    /////////////////POSSIVELMENTE FAZER EVENT SUBSCRIPTION//////////////////
    public static int check_ToD() throws UaException, InterruptedException, ExecutionException {
    	//TRY CATCH ROUTINE NEEDED
    	int result=0;
    	
        client.connect().get();
		
        NodeId nodeId_startday = new NodeId(4,"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String pieces_time = client.readValue(0, TimestampsToReturn.Both, nodeId_startday).toString().substring(29, 31);;
        if(pieces_time=="1"&& pieces_time_ant=="0") {
        	
        }
        
        pieces_time_ant=pieces_time;
       return 0;
		
	}
    
    public ArrayList<Machine> mach_stats(ArrayList<Machine> machines) throws InterruptedException, ExecutionException{

    	//Gets machine counts
		client.connect().get();
		short total=0;
		for(int i=0;i<7;i++) {
		
			NodeId nodeId_midday = new NodeId(4,maq_ids[i]);
			
			//Read array of nr of pieces of each type and save
			String type_count = client.readValue(0, TimestampsToReturn.Both, nodeId_midday).toString().substring(29, 31);//!!!!!!!!!!CUT RIGHT WAY
			for(int j=0;i<machines.get(i).op_pieces.length;j++) {machines.get(i).op_pieces[j]=Short.parseShort(""+type_count.charAt(j));}
			for(int j=0;i<machines.get(i).op_pieces.length;j++) {total+=machines.get(i).op_pieces[j];}
			machines.get(i).pieces_total=total;
			total=0;
			
			
			//Read tool in use
			type_count = client.readValue(0, TimestampsToReturn.Both, nodeId_midday).toString().substring(29, 31);//!!!!!!!!!!CUT RIGHT WAY
			machines.get(i).tool=Short.parseShort(""+type_count.charAt(5));
			
		}
		
				
		return machines;
	}
    
    public ArrayList<Dock> dock_stats(ArrayList<Dock> docks) throws InterruptedException, ExecutionException{

    	//Gets machine counts
		client.connect().get();
		short total=0;
		for(int i=0;i<3;i++) {
			
			NodeId nodeId_midday = new NodeId(4,dock_ids[i]);
			
			//Read array of nr of pieces of each type and save
			String type_count = client.readValue(0, TimestampsToReturn.Both, nodeId_midday).toString().substring(29, 31);//!!!!!!!!!!CUT RIGHT WAY
			for(int j=0;i<docks.get(i).nr_types.length;j++) {docks.get(i).nr_types[j]=Short.parseShort(""+type_count.charAt(j));}
			for(int j=0;i<docks.get(i).nr_types.length;j++) {total+=docks.get(i).nr_types[j];}
			docks.get(i).total=total;
			total=0;
			
		}
		
				
		return docks;
	}
    
    public static ArrayList<Piece> check_pieces(ArrayList<Piece> day_pieces) throws UaException, InterruptedException, ExecutionException { 
    	//returns number of finished pieces
   
    	client.connect().get();
    	int finished=0;
    	int nr_pieces=0;
        for(int j=0;j<day_pieces.size();j++) {
        	if(day_pieces.get(j).final_form!=0) nr_pieces++;
        }
        for (int i=0;i<12;i++) {
        	//checks all pieces to see if they're finished
        NodeId nodeId = new NodeId(4,array_ids[i]);
        //reads the array
        String variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(30, 47).replace(", ", "");
      
        if((""+variable.charAt(1))==Short.toString(day_pieces.get(i).final_form)) {
        	finished++;
        	day_pieces.get(i).finished=1;
        	day_pieces.get(i).machines[1]=Short.valueOf(""+variable.charAt(1));
        	
        }
        else {
        	day_pieces.get(i).machines[1]=Short.valueOf(""+variable.charAt(1));
        }
        
        
        
        if(finished==nr_pieces) {
        	int result=Database.update_stats_EoD(day_pieces);
        	if(result<0)         System.out.println("Error when updating statistics");
        }
        

  
        System.out.println(variable);
        System.out.println(i);
        System.out.println();
        }
        return day_pieces;
    }
    

}