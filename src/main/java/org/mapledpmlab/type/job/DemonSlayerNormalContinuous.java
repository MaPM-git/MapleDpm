package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperDemonSlayer;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class DemonSlayerNormalContinuous extends Job {

    public DemonSlayerNormalContinuous() {
        // 기본
        super();
        this.setName("데몬슬레이어(0초, 컨티, 극포실)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(3319680.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (326 + 201 + 72 + 249));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (326 + 201 + 72 + 249));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(21L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("데몬 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("웨폰 마스터리");
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("아웃레이지");
        passive.addAtt(20L);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("컨센트레이션");
        passive.addFinalDamage(1.3);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("이블 토쳐");
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("다크 바인드");
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("메타모포시스");
        passive.addDamage(45L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 웨폰 마스터리");
        passive.addAtt(31L);
        passive.addCriticalDamage(13.0);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-54L);
        this.addMainStat(-4L);
        this.addSubStat(-10L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new StrUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperDemonSlayer(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("이블 토쳐");
        doping.addFinalDamage(1.15);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("데몬 임팩트 : 데몬 체인");
        doping.addIgnoreDefenseList(15L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 웨폰 마스터리(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
