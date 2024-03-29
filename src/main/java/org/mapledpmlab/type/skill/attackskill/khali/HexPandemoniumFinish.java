package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexPandemoniumFinish extends AttackSkill implements HexSkill {
    public HexPandemoniumFinish() {
        this.setName("헥스 : 판데모니움(폭발)");
        this.setDamage(1375.0);
        this.setAttackCount(10L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setAddDamage(20L + 20);    // 헥스-보스 킬러, 리인포스
        this.getMultiAttackInfo().add(3420L + 720);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
