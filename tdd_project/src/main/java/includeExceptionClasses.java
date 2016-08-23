/**
 * Created by webonise on 23/8/16.
 */
class InvalidInputTypeException extends RuntimeException{
    InvalidInputTypeException(String message){
        super(message);
    }
}

class IndexOutOfBoundTypeException extends RuntimeException{
    IndexOutOfBoundTypeException(String message){
        super(message);
    }
}

class SwappingSameElementTypeException extends  RuntimeException{
    SwappingSameElementTypeException(String message){
        super(message);
    }
}