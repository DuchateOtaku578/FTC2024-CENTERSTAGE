package org.firstinspires.ftc.teamcode.codigopiola.autonomos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;


//@Disabled
@Autonomous(name="ChasisAutonomo2", group="Pushbot")

public class ChasisAutonomo2 extends LinearOpMode {



    @Override
    public void runOpMode() {

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(0, 0, 0);

        drive.setPoseEstimate(startPose);

        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(startPose)

                .splineTo(new Vector2d(40,40), Math.toRadians(0))
                .build();

        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            drive.followTrajectorySequence(trajSeq);

        }
    }
}
