package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BurstPileBunker extends AttackSkill {
    public BurstPileBunker() {
        this.setName("버스트 파일 벙커");
        this.setAttackCount(10L);
        this.setDamage(790.0);
        this.setDelay(150L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
