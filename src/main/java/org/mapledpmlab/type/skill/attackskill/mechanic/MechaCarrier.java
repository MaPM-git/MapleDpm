package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MechaCarrier extends AttackSkill {
    public MechaCarrier() {
        this.setName("메카 캐리어");
        this.setAttackCount(4L);
        this.setDamage(550.0);
        this.setInterval(30L);
        this.setDotDuration(70000L);
        this.addFinalDamage(2.11);          // 로봇 마스터리
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
