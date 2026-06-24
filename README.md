# Cricket Team Management System (Backend)

Package: com.hexaware.cricket

## Structure
src/main/java/com/hexaware/cricket/
  controller/  -> PlayerController.java
  dto/         -> PlayerDTO.java
  entity/      -> Player.java
  exception/   -> GlobalExceptionHandler.java, PlayerNotFoundException.java
  repo/        -> PlayerRepository.java
  service/     -> IPlayerService.java, PlayerServiceImpl.java
  CricketApplication.java

## Endpoints
GET    /api/players
POST   /api/players
GET    /api/players/{playerId}
PUT    /api/players/{playerId}
DELETE /api/players/{playerId}

## Run
Set MySQL password in application.properties, run CricketApplication (port 8080, db cricketdb).
