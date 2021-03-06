package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name="Annabelle", group="Experimenting")
public class AnnabelleOpMode extends OpMode {

    AnnabelleDriveController driveController;

    double forwardPower;
    double rotation;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        // Setup drive controller
        driveController = new AnnabelleDriveController(
                hardwareMap.dcMotor.get("left_front_motor"),
                hardwareMap.dcMotor.get("left_back_motor"),
                hardwareMap.dcMotor.get("right_front_motor"),
                hardwareMap.dcMotor.get("right_back_motor"),
                false
        );
        driveController.setPower(0);
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        forwardPower = gamepad1.left_stick_y;
        rotation = gamepad1.left_stick_x;

        telemetry.addData("Power", forwardPower);
        telemetry.addData("Rotation", rotation);

        driveController.setPower(forwardPower);
        driveController.setRotation(rotation);

        driveController.step(telemetry);
    }

}
