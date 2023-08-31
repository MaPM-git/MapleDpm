package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhotonWave extends AttackSkill {
    public PhotonWave() {
        this.setName("빛의 파동");
        this.setAttackCount(6L);
        this.setDamage(700.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
