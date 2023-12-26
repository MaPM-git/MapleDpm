package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotLauncherRM7Summon extends AttackSkill {
    public RobotLauncherRM7Summon() {
        this.setName("로봇 런처 : RM7");
        this.setDelay(630L);
        this.setRelatedSkill(new RobotLauncherRM7());
    }
}
