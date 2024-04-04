package org.mapledpmlab.type.skill.buffskill.lara;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class GrandisGoddessBlessingLara extends BuffSkill {
    public GrandisGoddessBlessingLara() {
        this.setName("그란디스 여신의 축복(라라)");
        this.setCooldown(0.0);  // 스택형이라 딜사이클에서 따로 처리
        this.setDelay(630L);
        this.setDuration(40L);
        this.setBuffDamage(40L);
    }
}
