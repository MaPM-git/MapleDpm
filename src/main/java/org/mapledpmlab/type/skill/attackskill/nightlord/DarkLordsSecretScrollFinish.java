package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkLordsSecretScrollFinish extends AttackSkill {
    public DarkLordsSecretScrollFinish() {
        this.setName("다크로드의 비전서(폭발)");
        this.setAttackCount(12L);
        this.setDamage(3430.0);
        this.setAddDamage(30L);
        this.addFinalDamage(1.6);       // 코어강화
        this.getMultiAttackInfo().add(12000L);
    }
}
