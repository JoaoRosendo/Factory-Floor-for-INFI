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
    static int id;
    static short tool=0;
    static double op_time=0;
    static short[] op_pieces;
    static short pieces_total;
	
	public static short getPieces_total() {
		return pieces_total;
	}

	public static void setPieces_total(short pieces_total) {
		Machine.pieces_total = pieces_total;
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

	public double getOp_time() {
		return op_time;
	}

	public void setOp_time(double op_time) {
		this.op_time = op_time;
	}

	public short[] getOp_pieces() {
		return op_pieces;
	}

	public void setOp_pieces(short[] op_pieces) {
		this.op_pieces = op_pieces;
	};
	
	
		    

}
