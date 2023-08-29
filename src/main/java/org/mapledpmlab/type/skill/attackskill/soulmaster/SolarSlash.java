package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SolarSlash extends AttackSkill {
    public SolarSlash() {
        this.setName("솔라 슬래시");
        this.setAttackCount(6L * 2);
        this.setDamage(830.0);
        this.setDelayByAttackSpeed(720L);
        this.setAddDamage(20L);         // 디바이드 앤 슬래시-리인포스
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
