package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagneticField extends AttackSkill {
    public MagneticField() {
        this.setName("마그네틱 필드");
        this.setAttackCount(1L);
        this.setDamage(200.0);
        this.setInterval(1020L);
        this.setDotDuration((long) (70000L * 1.42));
        this.addFinalDamage(2.11);              // 로봇 마스터리
        this.setAddDamage(20L);                 // 마그네틱 필드-리인포스
        this.addIgnoreDefenseList(20L);         // 마그네틱 필드-이그노어 가드
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
