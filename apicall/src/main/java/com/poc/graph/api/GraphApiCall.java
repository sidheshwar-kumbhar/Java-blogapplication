package com.poc.graph.api;

public class GraphApiCall {

	public static void main(String[] args) {

		String token = "Bearer EwCAA8l6BAAUwihrrCrmQ4wuIJX5mbj7rQla6TUAAW0pQVrxwCCrucoB0bmmLMPVIgqDzG24UUI/ksMG6c72CkZGLCS3tyvXxNlIxUOQPY7opQEJ97vTYk+qFVAzTVD/PYny+LvUpAeqRr/uHdQ3IXxTNSmb7h/bFCPUrh8H5G0pay4l0J1BKHX4CH2qDCOXMgj9EKIyFlT1swj9ecYgezflOLMGH5amfryRB3QrJus1bHMsYuMAQ2s3bG0F1v4mj9laz/JKnOm4MBwslXIwnhceNH8pPcarIU8GE+/6KCmDzeLFkNOV6QT4LCv120SMjEuneth069ZKy4jUZUCalijOqq9whigTlDEwflvN94gZ6mwlqnEuXsP6LijQ4EIDZgAACAHSGLbmAmmhUAL9tA2S3U2C5D9nDOqaB9PlA+1Ws8bQVo2J9mmUV3MAURVLyKF180zW3ZLz3Zqc8MKJ9aqz+ZEkzq/Fa+/nLCRuTLGxxg8ks6logcTGHJ+yaxjylmkxia53i8fgtQ9qWRa8SlAqgfXO3hU2uWH2eIrSJwaUt50Ov12IVNc4shDQ34SthuIFj/OvPATlCRjXB+oCa71J99icfpv0GN9hChplTtTp6N+3oPyOjhX7WVoLTSdk9xPd9BDx/Fxc4CxDtOW2+ze/FjUEwb3IRIHkCPczCzRtj5x0zK80FbazwIv7C7cFo53shwref4tllfReqOdQDxw1mz3Ma3uJWOD+w1L91OuVX2/4u4YW9ydxidPxVb62FK3zLi4y0kdbMvCt6qnFiwml689EZj4lsxTHsg/MtYKORqQM875BTOGVP3HcbjF6XpB5JdUEh4Qlvub2dIzrkaz45jvmZ4njCVvBHFuWsBdCroJlik2nDxeGnlXSWMdRIN+o1KETySITVL2az+iSDUDZ86dSEKWTrcjra6LD6bwLXbqLX1LNNyokXEZQrTqLpn/l/BNahtEQnwUUFklQU+JGN7JzvC28Wv3+g4Ax+0kqQami+hXWGmfNJ/eZgOIC6Ov6//l3b5bQ8fIFz0ro8YdbPgSh6SQHWllKFjQ3pn2ZcbgQvWzYItQ/OCWjPuYz0+2/LqDzqomiXJQEhWY7Ax7PnJRSmYlcgsIGbRjPEP7/UAz0z1w1nh3PU/PghQ71gu0IwFCwalumGlLyhQfjMuJ2LBnb5ziutQFRuDL5kAI=";
		String userId = "7e11af741938807f";

		GraphApiCallServiceImpl graphApiCallService = new GraphApiCallServiceImpl();
		graphApiCallService.getEmailMessages(token, userId);

	}

}
