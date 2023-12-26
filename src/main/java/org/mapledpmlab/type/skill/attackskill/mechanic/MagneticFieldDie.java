package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagneticFieldDie extends AttackSkill {
    public MagneticFieldDie() {
        this.setName("마그네틱 필드(자폭)");
        this.setAttackCount(1L);
        this.setDamage(550.0);
        this.addFinalDamage(2.11);              // 로봇 마스터리
        this.setAddDamage(20L);                 // 마그네틱 필드-리인포스
        this.addIgnoreDefenseList(20L);         // 마그네틱 필드-이그노어 가드
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new MagneticFieldSummon());
    }
}
