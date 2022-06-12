package MES;

import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;

import java.util.ArrayList;


import org.eclipse.milo.opcua.sdk.client.OpcUaClient;

import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;

import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;


public class Machine {
    public int id;
    public short tool=0;
    public int op_time=0; //seconds
    public short[] op_pieces= {0,0,0,0,0,0,0,0,0};
    public short pieces_total;
	
	public Machine(int id, short tool, int op_time, short[] op_pieces, short pieces_total) {
		super();
		this.id = id;
		this.tool = tool;
		this.op_time = op_time;
		this.op_pieces = op_pieces;
		this.pieces_total = pieces_total;
	}

	public  short getPieces_total() {
		return pieces_total;
	}

	public void setPieces_total(short pieces_total) {
		this.pieces_total = pieces_total;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getTool() {
		return tool;
	}

	public void setTool(short tool) {
		this.tool = tool;
	}

	public int getOp_time() {
		return op_time;
	}

	public void setOp_time(int op_time) {
		this.op_time = op_time;
	}

	public short[] getOp_pieces() {
		return op_pieces;
	}

	public void setOp_pieces(short[] op_pieces) {
		this.op_pieces = op_pieces;
	};
	
	
		    

}
