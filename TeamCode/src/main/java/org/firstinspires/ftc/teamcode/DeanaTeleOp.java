package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DeanaController", group="Production")
public class DeanaTeleOp extends OpMode {

    DeanaController controller;

    @Override
    public void init() {
        controller = new DeanaController(hardwareMap);
    }

    @Override
    public void loop() {

        // Movement
        if (gamepad1.dpad_right) controller.strafe(1.0);
        else if (gamepad1.dpad_left) controller.strafe(-1.0);
        else if (gamepad1.right_stick_x == 0 ) controller.move_forward(-gamepad1.left_stick_y);
        else if (gamepad1.left_stick_y == 0) controller.rotate(-gamepad1.right_stick_x);

        // Arm/Intake
        if (gamepad1.a) controller.extend_arm();
        if (gamepad1.b) controller.retract_arm();
        if (gamepad1.y) controller.starting_position();
        if (gamepad1.right_trigger > 0) controller.run_intake(-gamepad1.right_trigger);
        else controller.run_intake(gamepad1.left_trigger);
        if (gamepad1.left_bumper) controller.spin_cup();
        else if (gamepad1.right_bumper) controller.reset_cup();

        // Carousel
        if (gamepad1.x) controller.run_carousel(1.0);
        else controller.run_carousel(0.0);

        if (controller.arm_moving) controller.run_arm();

        telemetry.addData("Controller A ", gamepad1.id < 0 ? "not connected" : "connected");
        telemetry.addData("Controller B ", gamepad2.id < 0 ? "not connected" : "connected");
        telemetry.addData("Arm L Moving", controller.arm_l.arm_moving);
        telemetry.addData("Arm R Moving", controller.arm_r.arm_moving);
        telemetry.addData("Bumper L", gamepad1.left_bumper);
        telemetry.addData("Bumper R", gamepad1.right_bumper);
    }
}
