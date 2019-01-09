/**
 *
 * @author Schramm
 */
public enum ConnectFourEnum {
    IN_PROGRESS ("Game in Progress"), RED ("Red"), BLACK ("Black"), DRAW ("It's a draw!"), EMPTY(" ");
    
    private String value;
    
    /**
     * Returns the string contained in value.
     * @param value 
     */
    ConnectFourEnum( String value) {
        this.value = value;
    }
}