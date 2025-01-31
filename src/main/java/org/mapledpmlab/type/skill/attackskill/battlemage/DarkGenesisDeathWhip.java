package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkGenesisDeathWhip extends AttackSkill {
    public DarkGenesisDeathWhip() {
        this.setName("다크 제네시스 : 데스 휩");
        this.setAttackCount(10L);
        this.setDamage(250.0);
        this.setCooldown(30.0);
        this.setDelayByAttackSpeed(900L);
        this.setAddDamage(20L);             // 다크 제네시스-에디셔널 리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(900L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
