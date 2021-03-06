package edu.ufl.cise.cn.peer2peer.entities;

import edu.ufl.cise.cn.peer2peer.utility.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class HandshakeMessage.
 * This function creates handshake message and provides function to get the Handshake message. 
 */
public class HandshakeMessage implements PeerMessage{
	
	/** The hand shake header. */
	private String handShakeHeader;
	
	/** The peer id. */
	private String peerID;
	
	private static int instanceCounter;
	
	private int messageNumber;
	
	public void setPeerID(String peerID) {
		this.peerID = peerID;
	}

	/**
	 * Instantiates a new handshake message.
	 */
	private HandshakeMessage(){
		
	}
	
	/**
	 * Gets the single instance of HandshakeMessage.
	 *
	 * @return single instance of HandshakeMessage
	 */
	public static HandshakeMessage getInstance(){
		HandshakeMessage handshakeMessage = new HandshakeMessage();
		boolean isSuccessful = handshakeMessage.init();
		if(isSuccessful == false){
			handshakeMessage.close();
			handshakeMessage = null;
		}
		return handshakeMessage;
	}
	
	/**
	 * Inits the.
	 *
	 * @return true, if successful
	 */
	private boolean init(){
		instanceCounter++;
		messageNumber = instanceCounter; 
		return true;
	}
	
	/**
	 * Close.
	 */
	public void close(){
		
	}
	
	/**
	 * Gets the handshake message. 
	 *
	 * @return the handshake message
	 */
	public byte[] getHandshakeMessage(){
		return null;
	}

	public int getType() {
		return Constants.HANDSHAKE_MESSAGE;
	}

	public int getMessageLength() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getPeerID(){
		return peerID;
	}

	public int getMessageNumber() {
		return messageNumber;
	}
}
