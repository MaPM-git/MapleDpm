package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RobotLauncherRM7 extends AttackSkill {
    public RobotLauncherRM7() {
        this.setName("로봇 런처 : RM7");
        this.setAttackCount(1L);
        this.setDamage(250.0 + 143);
        this.setInterval(450L);
        this.setDotDuration((long) (70000L * 1.42));
        this.addFinalDamage(2.11);              // 로봇 마스터리
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
